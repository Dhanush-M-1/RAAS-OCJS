#include <bits/stdc++.h>
using namespace std;
 
int main(){
	int n,m,x; 
	cin>>n>>m; 
	int a[n][2],b[n],c[m][2],d[n];
	for(int i=0;i<n;i++){
		for(int j=0;j<2;j++){
			cin>>a[i][j];
		}
	}
	for(int i=0;i<m;i++){
		for(int j=0;j<2;j++){
			cin>>c[i][j];
		}
	}
	for(int k=0;k<n;k++){;
		for(int l=0;l<m;l++){
			x=abs(a[k][0]-c[l][0])+abs(a[k][1]-c[l][1]);
			if(b[k]>x||l==0) {b[k]=x; d[k]=l+1;}
		}
	}
	for(int y=0;y<n;y++){
		cout<<d[y]<<endl;
	}
	return 0;
}

