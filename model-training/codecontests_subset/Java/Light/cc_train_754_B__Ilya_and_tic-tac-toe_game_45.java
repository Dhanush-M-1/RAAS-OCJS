var i,
  j,
  size,
  rows,
  columns,
  diagonals,
  yes;
size = 4;
rows = [];
for ( i = 0; i < size; ++i ) {
  rows[ i ] = readline();  
}

columns = new Array( size );
columns.fill( "" );
for ( i = 0; i < size; ++i ) {
  for ( j = 0; j < size; ++j ) {
    columns[j] += rows[i][j];
  }
}

diagonals = new Array( 6 );
diagonals[0] = rows[0][0] + rows[1][1] + rows[2][2] + rows[3][3];
diagonals[1] = rows[3][0] + rows[2][1] + rows[1][2] + rows[0][3];

diagonals[2] = rows[0][1] + rows[1][2] + rows[2][3];
diagonals[3] = rows[1][0] + rows[2][1] + rows[3][2];

diagonals[4] = rows[0][2] + rows[1][1] + rows[2][0];
diagonals[5] = rows[1][3] + rows[2][2] + rows[3][1];

yes = false;
var pattern = /(xx\.)|(\.xx)|(x\.x)/g;
var willWin = function( segment ) {
  return pattern.test( segment );
};
for ( i = 0; i < rows.length && !yes; ++i ) {
  if ( willWin( rows[ i ] ) ) {
    yes = true;
  }
}

for ( i = 0; i < columns.length && !yes; ++i ) {
  if ( willWin( columns[ i ] ) ) {
    yes = true;
  }
}

for ( i = 0; i < diagonals.length && !yes; ++i ) {
  if ( willWin( diagonals[ i ] ) ) {
    yes = true;
  }
}

print( yes ? "YES" : "NO" );
