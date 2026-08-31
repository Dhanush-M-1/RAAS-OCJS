
function ver( a , i , j )
{
    if ( i > 1 ) return false;
    return a[i][j]=='x' && a[i+1][j]=='x' && a[i+2][j]=='x';
}

function hor( a , i , j )
{
    if ( j > 1 ) return false;
    return a[i][j]=='x' && a[i][j+1]=='x' && a[i][j+2]=='x';
}

function diar( a , i , j )
{
    if ( i > 1 || j > 1 ) return false;
    return a[i][j]=='x' && a[i+1][j+1]=='x' && a[i+2][j+2]=='x';
}

function dial( a , i , j )
{
    if ( i > 1 || j < 2 ) return false;
    return a[i][j]=='x' && a[i+1][j-1]=='x' && a[i+2][j-2]=='x';
}

function check( a )
{
    var ret = false;
    for ( var i=0 ; i<4 ; i++ )
        for ( var j=0 ; j<4 ; j++ )
        {
            ret |= ver( a , i , j );
            ret |= hor( a , i , j );
            ret |= diar( a , i , j );
            ret |= dial( a , i , j );
        }
    return ret;
}

function replace( s , i , c )
{
    return s.substring(0,i) + c + s.substring(i+1);
}

function main()
{
    var a = new Array( 4 );
    
    for ( var i=0 ; i<4 ; i++ )
        a[i] = readline();
        
    var ans = false;
    for ( var i=0 ; i<4 ; i++ )
        for ( var j=0 ; j<4 ; j++ )
        {
            if ( a[i][j] == '.' )
            {
                a[i] = replace( a[i] , j , 'x' );
                ans |= check( a );
                a[i] = replace( a[i] , j , '.' );
            }
        }
    
    if ( ans ) print( "YES" );
    else print( "NO" );
    
} main();









