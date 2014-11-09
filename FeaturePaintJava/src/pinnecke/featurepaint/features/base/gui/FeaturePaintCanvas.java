package pinnecke.featurepaint.features.base.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import pinnecke.featurepaint.features.base.core.Configuration;

public class FeaturePaintCanvas extends Canvas {

	private Dimension imageDimension = new Dimension(800, 600);

	public Dimension getImageDimension() {
		return imageDimension;
	}

	public FeaturePaintCanvas() {
		setupImageSize();
		setupCanvasDecoration();
		setupCursor();
	}

	private List<Point> drawHistory = new ArrayList<Point>();

	@Override
	public void paint(Graphics g) {

		if (Configuration.isActivated(Configuration.FEATURE_EDITING_PEN_TOOL)) {
			sx = -1;
			sy = -1;

			for (Point p : drawHistory)
				draw(p);
		}

		super.repaint();
	}

	private void setupCursor() {
		addMouseListener(new MouseAdapter() {

			public void mouseExited(MouseEvent e) {
				setCursor(Cursor.getDefaultCursor());
			}

			public void mouseEntered(MouseEvent e) {
				if (Configuration
						.isActivated(Configuration.FEATURE_EDITING_PEN_TOOL)) {
					Toolkit toolkit = Toolkit.getDefaultToolkit();
					Image image = toolkit.getImage(this.getClass().getResource(
							"/pen.png"));
					Point hotSpot = new Point(0, 0);
					setCursor(toolkit.createCustomCursor(image, hotSpot, "Pen"));
				}
			}

		});

		addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) {

				drawHistory.add(e.getPoint());

			}

		});
	}

	int sx = -1;
	int sy = -1;

	private void draw(Point point) {
		int x = (int) point.getX();
		int y = (int) point.getY();

		if (sx >= 0 && sy >= 0) {
			Graphics2D g2d = (Graphics2D) getGraphics();
			g2d.drawLine(sx, sy, x, y);
		}

		sx = x;
		sy = y;
	}

	private void setupCanvasDecoration() {
		super.setBackground(Color.WHITE);
	}

	public void setImageSize(float scale) {
		Graphics2D g2d = (Graphics2D) super.getGraphics();
		if (scale > 0 && scale < 10)
			g2d.scale(scale, scale);
	}

	private void setupImageSize() {
		final Dimension dim = new Dimension(800, 600);
		super.setMinimumSize(dim);
		super.setPreferredSize(dim);
		super.setMaximumSize(dim);
	}

}
