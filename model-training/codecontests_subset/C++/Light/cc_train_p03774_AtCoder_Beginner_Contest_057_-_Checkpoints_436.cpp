#include<iostream>
#include<stdlib.h>
using namespace std;
int main(){
	int a[55][2];
	int b[55][2];
	int n,m,i,j,k,x,y;
	cin >> n >> m;
	for(i=0;i<n;i++){
		cin >> a[i][0] >> a[i][1];
	}
	for(i=0;i<m;i++){
		cin >> b[i][0] >> b[i][1];
	}
	for(i=0;i<n;i++){
		k=abs(a[i][0]-b[0][0])+abs(a[i][1]-b[0][1]);
		x=k;
		y=0;
		for(j=1;j<m;j++){
			k=abs(a[i][0]-b[j][0])+abs(a[i][1]-b[j][1]);
			if(k<x){
				x=k;
				y=j;
			}
		}
		cout << y+1 << endl;
	}
	cout << endl;
}
