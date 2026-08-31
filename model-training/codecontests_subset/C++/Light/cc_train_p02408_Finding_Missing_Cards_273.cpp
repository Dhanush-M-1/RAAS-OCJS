#include <iostream>
using namespace std;
int main(){
	int i,j,k,x,n;
	int a[4][13]={0};
	char m;
	cin >> n;
	for( k=0;k<n;k++ ){
		cin >> m >> x;
		if( m == 'S')
			a[0][x-1]=1;
		else if( m == 'H')
			a[1][x-1]=1;
		else if( m == 'C')
			a[2][x-1]=1;
		else if( m == 'D')
			a[3][x-1]=1;
	}
		
	for(i=0;i<4;i++){
		for(j=0;j<13;j++){
			if( a[i][j] ) continue;
				if( i==0 ) m = 'S';
				else if( i==1 ) m = 'H';
				else if( i==2 ) m = 'C';
				else if( i==3 ) m = 'D';
					cout << m << " " << j+1 << endl;
		}	
	}
	return 0;
}