function ProblemSolver() {
    this.HAS_TEST_CASES = false;
    this.INPUT_FILE_NAME = "test.in";
    this.OUTPUT_FILE_NAME = "out.txt";
    this.DO_OUTPUT_TO_FILE = false;
    this.CLEAR_ARRAY_PER_CASE = false;

    this.solveCase = function() {
        var res , i , j , fl , cn , temp , l1 , l2 , l3 , lim , a , b , c , d , inf , r1 , r2 , r3 , bb , cc , xrr , yrr , u , x , y ;
        res = '' ;
        
        lim = 30 ;
        inf = 1000000 ;
        
        l1 = this.a.length ;
        l2 = this.b.length ;
        l3 = this.c.length ;
        
        this.arr = [] ;
        for( i = 0 ; i < lim ; i++ ) {
            this.arr.push( 0 ) ;
        }
        this.brr = [] ;
        for( i = 0 ; i < lim ; i++ ) {
            this.brr.push( 0 ) ;
        }
        this.crr = [] ;
        for( i = 0 ; i < lim ; i++ ) {
            this.crr.push( 0 ) ;
        }
        
        for( i = 0 ; i < l1 ; i++ ) {
            a = this.a.charCodeAt( i ) - 'a'.charCodeAt( 0 ) ;
            this.arr[ a ]++ ;
        }
        for( i = 0 ; i < l2 ; i++ ) {
            a = this.b.charCodeAt( i ) - 'a'.charCodeAt( 0 ) ;
            this.brr[ a ]++ ;
        }
        for( i = 0 ; i < l3 ; i++ ) {
            a = this.c.charCodeAt( i ) - 'a'.charCodeAt( 0 ) ;
            this.crr[ a ]++ ;
        }
        
        b = inf ;
        for( i = 0 ; i < lim ; i++ ) {
            if( this.brr[ i ] > 0 ) {
                b = Math.min( b , Math.floor( this.arr[ i ] / this.brr[ i ] ) ) ;
            } 
        }

        r1 = [] ;
    	yrr = [] ;
        for( i = 0 ; i < lim ; i++ ) {
            yrr.push( 0 ) ;
        }
        x = 0 ;
        y = 0 ;
    	for( u = 0 ; u <= b ; u++ ) {
            xrr = [] ;
            for( i = 0 ; i < lim ; i++ ) {
                xrr.push( this.arr[ i ] - u * this.brr[ i ] ) ;
            }
            c = inf ;
            for( i = 0 ; i < lim ; i++ ) {
                if( this.crr[ i ] > 0 ) {
                    c = Math.min( c , Math.floor( xrr[ i ] / this.crr[ i ] ) ) ;
                }
            }
            for( i = 0 ; i < lim ; i++ ) {
                xrr[ i ] -= c * this.crr[ i ] ;
            }
            if( u + c > x + y ) {
            	x = u ;
            	y = c ;
                for( i = 0 ; i < lim ; i++ ) {
                    yrr[ i ] = xrr[ i ] ;
                }
            }
    	}
    	for( i = 0 ; i < x ; i++ ) {
    		r1.push( this.b ) ;
    	}
    	for( i = 0 ; i < y ; i++ ) {
    		r1.push( this.c ) ;
    	}
    	if( x > 0 || y > 0 ) {
    		for( i = 0 ; i < lim ; i++ ) {
	            this.arr[ i ] = yrr[ i ] ;
	        }
    	}
       	
        res += r1.join( '' ) ; 
        for( i = 0 ; i < lim ; i++ ) {
            for( j = 0 ; j < this.arr[ i ] ; j++ ) {
                res += String.fromCharCode( 'a'.charCodeAt( 0 ) + i ) ;
            }
        }
        print( res );
    };

    this.init = function() {
        this.lim1 = 100010;
        this.lim2 = 110;
        this.cc = 1;
        this.ind = 1;
        this.n = 0;
        this.cn = 0;
        this.declareAndFillArrays();
    };

    this.getInput = function( irObj ) {
        var hasMoreInput , i;
        hasMoreInput = true;
        try {
            this.a = irObj.nextString();
	        this.b = irObj.nextString();
	        this.c = irObj.nextString();
        }
        catch( ex ) {
            hasMoreInput = false;
        }
        return hasMoreInput;
    };

    this.clearArraysPerCase = function() {
        var i;
        this.arr = new Array();
        this.adjList = new Array();
        for( i = 0 ; i < this.lim1 ; i++ ) {
            this.arr.push( 0 );
            this.adjList.push( new Array() );
        }
    };

    this.clearPerCase = function() {
        this.cn = 0;
        this.cc++;
        if( this.CLEAR_ARRAY_PER_CASE == true ) {
            this.clearArraysPerCase() ;
        }
    };

    this.declareAndFillArrays = function() {
        var i , j;
        this.srr = new Array();
        this.vis = new Array();
        this.arr = new Array();
        this.brr = new Array();
        this.memo = new Array();
        this.done = new Array();
        this.adjList = new Array();
        for( i = 0 ; i < this.lim1 ; i++ ) {
            this.srr.push( "" );
            this.vis.push( 0 );
            this.arr.push( 0 );
            this.brr.push( 0 );
            this.adjList.push( new Array() );
        }
        for( i = 0 ; i < this.lim2 ; i++ ) {
            this.memo.push( new Array() );
            this.done.push( new Array() );
            for( j = 0 ; j < this.lim2 ; j++ ) {
                this.memo[ i ].push( -1 );
                this.done[ i ].push( 0 );
            }
        }
    };

    this.init();
}

function InputReader() {
    var self = this ;
    this.allLines = new Array();
    this.currrentLineNumber = 0;
    this.currrentCharacterIndex = 0;
    this.callBackFunction = null ;
    this.parentContext = null ;

    this.readAllLines = function() {
        var singleLine;
        while( true ) {
            try {
                singleLine = readline();
                if( singleLine == null ) {
                    break;
                }
            }
            catch( ex ) {
                break;
            }
            this.allLines.push( singleLine );
        }
    };
    
    this.readAllLinesFromRhino = function() {
        var brObj , line ;
        importPackage( java.io ) ;
        importPackage( java.lang ) ;
        brObj = new BufferedReader( new InputStreamReader( System[ 'in' ] ) ) ;
        this.allLines = [] ;
        while( true ) {
            line = brObj.readLine() ;
            if( line == null ) {
                break;
            }
            this.allLines.push( line ) ;
        }
    };
    
    this.readSingleLinesFromNodeJsJudgeServer = function( chunk ) {
        self.chunkData += chunk ;
    };

    this.readEndFromNodeJsJudgeServer = function() {
        self.parseRawData( self.chunkData ) ;
        self.parentContext.runCases() ;
    };
    
    this.readAllLinesFromNodeJsJudgeServer = function( parentContext ) {
        this.parentContext = parentContext ;
        process.stdin.resume() ;
        process.stdin.setEncoding( 'utf8' ) ;
        this.chunkData = '' ;
        process.stdin.on( 'data' , this.readSingleLinesFromNodeJsJudgeServer ) ;
        process.stdin.on( 'end' , this.readEndFromNodeJsJudgeServer ) ;
    };

    this.parseRawData = function( data ) {
        var len , i , currentString;
        len = data.length;
        currentString = "";
        this.allLines = [] ;
        for( i = 0 ; i < len ; i++ ) {
            if( data[ i ] == '\r' ) {
            }
            else if( data[ i ] == '\n' ) {
                this.allLines.push( currentString );
                currentString = "";
            }
            else {
                currentString += data[ i ];
            }
        }
        if( currentString != "" ) {
            this.allLines.push( currentString );
        }
    };

    this.readAllLinesFromFile = function( inputFileName ) {
        var currentDirectory , fsObj , inputFilePath , rawData;
        fsObj = require( 'fs' );
        currentDirectory = __dirname;
        inputFilePath = currentDirectory + "\\" + inputFileName;
        rawData = fsObj.readFileSync( inputFilePath , "utf8" );
        this.parseRawData( rawData );
    };

    this.next = function( flag ) {
        var len , i , startIdx , res , endIdx;
        if( flag == 0 ) {
            if( this.currrentCharacterIndex != 0 ) {
                this.currrentLineNumber++;
                this.currrentCharacterIndex = 0;
            }
            res = "";
            len = this.allLines[ this.currrentLineNumber ].length;
            if( typeof( len ) == 'function' ) {
                len = this.allLines[ this.currrentLineNumber ].length() ;
            }
            for( i = this.currrentCharacterIndex ; i < len ; i++ ) {
                res += '' + this.allLines[ this.currrentLineNumber ].charAt( i ) ;
            }
            this.currrentLineNumber++;
            this.currrentCharacterIndex = 0;
            return res;
        }
        while( true ) {
            if( this.currrentLineNumber >= this.allLines.length ) {
                throw new Error( "No more tokens available!" );
            }
            startIdx = -1;
            len = this.allLines[ this.currrentLineNumber ].length;
            if( typeof( len ) == 'function' ) {
                len = this.allLines[ this.currrentLineNumber ].length() ;
            }
            for( i = this.currrentCharacterIndex ; i < len ; i++ ) {
                if( this.allLines[ this.currrentLineNumber ].charCodeAt( i ) != ' '.charCodeAt( 0 ) ) {
                    startIdx = i;
                    break;
                }
            }
            if( startIdx == -1 ) {
                this.currrentLineNumber++;
                this.currrentCharacterIndex = 0;
                continue;
            }
            res = "";
            endIdx = len - 1 ;
            for( i = startIdx ; i < len ; i++ ) {
                if( this.allLines[ this.currrentLineNumber ].charCodeAt( i ) == ' '.charCodeAt( 0 ) ) {
                    endIdx = i;
                    break;
                }
                if( this.allLines[ this.currrentLineNumber ].charCodeAt( i ) >= 48 && this.allLines[ this.currrentLineNumber ].charCodeAt( i ) <= 57 ) {
                    res += '' + ( this.allLines[ this.currrentLineNumber ].charCodeAt( i ) - 48 ) ;
                }
                else {
                    res += '' + this.allLines[ this.currrentLineNumber ].charAt( i );
                }
            }
            this.currrentCharacterIndex = endIdx;
            if( endIdx == len - 1 ) {
                this.currrentLineNumber++;
                this.currrentCharacterIndex = 0;
            }
            return res;
        }
    };

    this.nextInt = function() {
        return parseInt( this.next( 1 ) );
    };

    this.nextDouble = function() {
        return parseFloat( this.next( 1 ) );
    };

    this.nextString = function() {
        return this.next( 1 );
    };

    this.nextLine = function() {
        return this.next( 0 );
    };
}

function FileOutputHandler() {
    this.resultantStringArray = new Array();

    this.addNewLine = function( newString ) {
        this.resultantStringArray.push( newString );
    };

    this.clearPercase = function() {
        this.resultantStringArray = new Array();
    };

    this.flushOutOutputToFile = function( outputFileName ) {
        var i , sz , res , currentDirectory , fsObj , outputFilePath;
        res = "";
        sz = this.resultantStringArray.length;
        for( i = 0 ; i < sz ; i++ ) {
            if( i != 0 ) {
                res += "\n";
            }
            res += this.resultantStringArray[ i ];
        }
        fsObj = require( 'fs' );
        currentDirectory = __dirname;
        outputFilePath = currentDirectory + "\\" + outputFileName;
        fsObj.writeFileSync( outputFilePath , res );
        this.clearPercase();
    };
}

function CodeExecutioner() {
    this.irObj = new InputReader();
    this.psObj = new ProblemSolver();
    this.fohObj = new FileOutputHandler();

    this.runCases = function() {
        if( this.psObj.HAS_TEST_CASES == true ) {
            testCases = this.irObj.nextInt();
            for( i = 0 ; i < testCases ; i++ ) {
                this.psObj.clearPerCase();
                this.psObj.getInput( this.irObj );
                this.psObj.solveCase();
            }
        }
        else {
            while( true ) {
                this.psObj.clearPerCase();
                hasMoreTestCases = this.psObj.getInput( this.irObj );
                if( hasMoreTestCases == false ) {
                    break;
                }
                this.psObj.solveCase();
            }
        }
        if( this.psObj.DO_OUTPUT_TO_FILE == true ) {
            this.fohObj.flushOutOutputToFile( this.psObj.OUTPUT_FILE_NAME );
        }
    };

    this.detectEnvironmentType = function() {
        var environmentType = null ;
        try {
            if( importPackage != null ) {
                environmentType = 'rhino' ;
            }
        }
        catch( ex1 ) {
            try {
                //for nodejs local server check
                if( __dirname != null && readline != null && typeof( readline ) != 'function' ) {
                    environmentType = 'local-node-js' ;
                }
            }
            catch( ex2 ) {
                try {
                    if( readline == null || typeof( readline ) != 'function' ) {
                        environmentType = 'server-node-js' ;
                    }
                    else {
                        try {
                            if( Map != null ) {
                                environmentType = 'spider-monkey' ;
                            }
                            else {
                                environmentType = 'javascript-v8' ;
                            }
                        }
                        catch( ex3 ) {
                            environmentType = 'javascript-v8' ;
                        }
                    }
                }
                catch( ex3 ) {
                    environmentType = 'server-node-js' ;
                }
            }
        }
        return environmentType ;
    };

    this.configureStreamsAndReadInput = function() {
        var testCases , i , hasMoreTestCases , isLocal , localContext , isNodeJsJudgeServer , environmentType ;
        isNodeJsJudgeServer = false ;
        environmentType = this.detectEnvironmentType() ;
        if( environmentType == 'local-node-js' ) {
            try {
                if( print == null || typeof( print ) != 'function' ) {
                    print = console.log;
                }
            }
            catch( ex ) {
                print = console.log;
            }
            if( this.psObj.DO_OUTPUT_TO_FILE == true ) {
                localContext = this.fohObj;
                print = function() {
                    localContext.addNewLine.apply( localContext , arguments );
                }
            }
            this.irObj.readAllLinesFromFile( this.psObj.INPUT_FILE_NAME );
            this.runCases() ;
        }
        else if( environmentType == 'server-node-js' ) {
            try {
                if( print == null || typeof( print ) != 'function' ) {
                    print = console.log;
                }
            }
            catch( ex ) {
                print = console.log;
            }
            this.irObj.readAllLinesFromNodeJsJudgeServer( this ) ;
        }
        else if( environmentType == 'javascript-v8' ) {
            this.irObj.readAllLines();
            this.runCases() ;
        }
        else if( environmentType == 'rhino' ) {
            this.irObj.readAllLinesFromRhino();
            this.runCases() ;
        }
        else if( environmentType == 'spider-monkey' ) {
            this.irObj.readAllLines();
            this.runCases() ;
        }
    };
    
    this.configureStreamsAndReadInput();
}

new CodeExecutioner();