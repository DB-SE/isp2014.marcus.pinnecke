/**
 * TODO description
 */
public class ProgramExamples {

	
//	1 Byte OPCODE	2 Byte OPERAND
//	
//	Stack
//	=====
//	Integer Stack
//	
//	Constant Pool
//	=============
//	
//	ID  | Identifier
//	-------------------
//	3	|	Int					(CONST INT 10)
//	4	| 	Float				(CONST INT 11)
//	5	|	Long				(CONST INT 12)
//	6	| 	Double				(CONST INT 13)
//	7	|	String				(CONST INT 14)
//	-------------------
//	100 | Sandbox Write			(CONST INT 6661)	array of data
//	-------------------
//	101 | System Exit			(CONST INT 6662)	exit code
//	102 | System Write			(CONST INT 6663)	ram_address, length
//	
//	Mnemonic	|	OpCode (hex)	|	Operands (short		|	Stack (before->after) |		Description
//	------------|-------------------|-----------------------|-------------------------|------------------
//	newarray	|   00				|   index				|	count -> reference	  | 	create a new array of references of length *count* and component type identified by the class reference *index*
//	bipush		|   01				|   value				|   value				  | 	pushes value as integer into stack
//	arraysto	|	02				|	address				|	reference -> _		  |		Writes entire content of array reference to memory at address			
//	getstatic	|   03				|   index				|	-> value			  |		Gets the value of constant object with id index 
//	castore		|   04				|   0					|   index, value, arrayref|		Stores value at array arrayred at position index
//	aaload		|	05				|	0					|	index → value,arrayref	|	load onto the stack a reference from an array
//	invokevirtual | 06				|	0					|	constID, ArgCount, [a1,...,a_ArgCount]	->	|	invokes a methode constID from constant pool with ArgCount arguments. The return value is pushed to stack
//	dup			|	07				|	0					|	value -> value, value |		Duplicates the stacks top

	 
	
	public static byte newarray = 0x00;
	public static byte bipush = 0x01;
	public static byte arraysto = 0x02;
	public static byte getstatic = 0x03;
	public static byte castore = 0x04;
	public static byte aaload = 0x05;
	public static byte invokevirtual = 0x06;
	public static byte dup = 0x07;
	
	final static byte[] PROG_HELLO_WORLD_STACK = new byte[] {
	// This program prints "Hello World" via Sandbox Write
	// to the screen. There's access to stack but not the
	// RAM.	
			bipush, 0, 100, // d
			bipush, 0, 108, // l
			bipush, 0, 114,	// r
			bipush, 0, 111,	// o
			bipush, 0, 87,	// W
			bipush, 0, 32,	// 
			bipush, 0, 111, // o
			bipush, 0, 108, // l
			bipush, 0, 108, // l
			bipush, 0, 101, // e
			bipush, 0, 72,	// H
			bipush, 0, 11,	// #Zeichen
			bipush, 0, 100,	// Sandbox write
			invokevirtual, 0, 0 
	};
	
	final static byte[] PROG_HELLO_WORLD_ARRAY_REF = new byte[] {
		// This program prints "Hello World" via Sandbox Write
		// to the screen. The text is stored into an array
		// but there is no access to RAM.	
			bipush, 	0, 11,
			newarray, 	0, 3,	// new int[11]
			
			dup, 		0, 0,
			bipush, 	0, 72,	// H
			bipush, 	0, 0,	// pos 0
			castore, 	0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 101,	// a
			bipush, 	0, 1,	// pos 1
			castore, 	0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 108,	// l
			bipush, 	0, 2,	// pos 2
			castore, 	0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 108,	// l
			bipush, 	0, 3,	// pos 3
			castore, 	0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 111,	// o
			bipush, 	0, 4,	// pos 4
			castore, 	0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 32,	// 
			bipush, 	0, 5,	// pos 5
			castore, 	0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 87,	// W
			bipush, 	0, 6,	// pos 6
			castore, 	0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 111,	// o
			bipush, 	0, 7,	// pos 7
			castore, 	0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 114,	// r
			bipush, 	0, 8,	// pos 8
			castore, 	0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 108,	// l
			bipush, 	0, 9,	// pos 9
			castore, 	0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 100,	// d
			bipush, 	0, 10,	// pos 10
			castore, 	0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 0,	// pos
			aaload,		0, 0,
			bipush, 	0, 1,	// #Zeichen
			bipush, 	0, 100,	// Sandbox write
			invokevirtual, 0, 0,			
			
			dup, 		0, 0,
			bipush, 	0, 1,	// pos
			aaload,		0, 0,
			bipush, 	0, 1,	// #Zeichen
			bipush, 	0, 100,	// Sandbox write
			invokevirtual, 0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 2,	// pos
			aaload,		0, 0,
			bipush, 	0, 1,	// #Zeichen
			bipush, 	0, 100,	// Sandbox write
			invokevirtual, 0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 3,	// pos
			aaload,		0, 0,
			bipush, 	0, 1,	// #Zeichen
			bipush, 	0, 100,	// Sandbox write
			invokevirtual, 0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 4,	// pos
			aaload,		0, 0,
			bipush, 	0, 1,	// #Zeichen
			bipush, 	0, 100,	// Sandbox write
			invokevirtual, 0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 5,	// pos
			aaload,		0, 0,
			bipush, 	0, 1,	// #Zeichen
			bipush, 	0, 100,	// Sandbox write
			invokevirtual, 0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 6,	// pos
			aaload,		0, 0,
			bipush, 	0, 1,	// #Zeichen
			bipush, 	0, 100,	// Sandbox write
			invokevirtual, 0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 7,	// pos
			aaload,		0, 0,
			bipush, 	0, 1,	// #Zeichen
			bipush, 	0, 100,	// Sandbox write
			invokevirtual, 0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 8,	// pos
			aaload,		0, 0,
			bipush, 	0, 1,	// #Zeichen
			bipush, 	0, 100,	// Sandbox write
			invokevirtual, 0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 9,	// pos
			aaload,		0, 0,
			bipush, 	0, 1,	// #Zeichen
			bipush, 	0, 100,	// Sandbox write
			invokevirtual, 0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 10,	// pos
			aaload,		0, 0,
			bipush, 	0, 1,	// #Zeichen
			bipush, 	0, 100,	// Sandbox write
			invokevirtual, 0, 0,
			
		};
	
	final static byte[] PROG_ACCESS_CONSTANT_POOL_TYPES = new byte[] {
		// This program access constant pool types. Depending on 
		// access level types, sandbox methods or kernel methods
		// can be loaded. This tests Level 1: Types
			getstatic, 0, 3, // Int
			getstatic, 0, 4, // Float
			getstatic, 0, 5, // Long
			getstatic, 0, 6, // Double
			getstatic, 0, 7  // String
	};
	
	final static byte[] PROG_ACCESS_CONSTANT_POOL_SANDBOX_METHODS = new byte[] {
		// This program access constant pool types. Depending on 
		// access level types, sandbox methods or kernel methods
		// can be loaded. This tests Level 2: Types and Sandbox
			getstatic, 0, 3, // Int
			getstatic, 0, 4, // Float
			getstatic, 0, 5, // Long
			getstatic, 0, 6, // Double
			getstatic, 0, 7, // String
		
			getstatic, 0, 100, // Sandbox write
	};
	
	final static byte[] PROG_ACCESS_CONSTANT_POOL_KERNEL_METHODS = new byte[] {
		// This program access constant pool types. Depending on 
		// access level types, sandbox methods or kernel methods
		// can be loaded. This tests Level 3: Types, Sandbox and Kernel 
			getstatic, 0, 3, // Int
			getstatic, 0, 4, // Float
			getstatic, 0, 5, // Long
			getstatic, 0, 6, // Double
			getstatic, 0, 7, // String
		
			getstatic, 0, 100, // Sandbox write
			
			getstatic, 0, 101, // System exit
			getstatic, 0, 102, // System write
	};
	
	final static byte[] PROG_RAM_MANIPULATION = new byte[] {
		// This program writes data to RAM at address 0 and displays a snapshot of the RAM
		// This a critical access because this manipulates the program code
		// (because program code is stored in the same RAM at address 0)
			bipush, 	0, 11,
			newarray, 	0, 3,	// new int[11]
			
			dup, 		0, 0,
			bipush, 	0, 72,	// H
			bipush, 	0, 0,	// pos 0
			castore, 	0, 0,
			
			dup, 		0, 0,
			bipush, 	0, 105,	// i
			bipush, 	0, 1,	// pos 1
			castore, 	0, 0,
			
			dup, 		0, 0,
			dup, 		0, 0,
			bipush, 	0, 33,	// !
			bipush, 	0, 1,	// pos 1
			castore, 	0, 0,
			
			arraysto,	0, 1,	// copy array #1 to RAM
			
			bipush,		0, 40,	// Extract 40 bytes
			bipush,		0, 0,	// RAM address
			bipush, 	0, 2,	// 2 arguments
			bipush, 	0, 102,	// System write
			invokevirtual, 0, 0,
			
			bipush, 	0, 42,	// exit code
			bipush, 	0, 1,	// 1 argument, exit code
			bipush, 0, 101,  // System exit
			invokevirtual, 0, 0,
	};
	
	
}