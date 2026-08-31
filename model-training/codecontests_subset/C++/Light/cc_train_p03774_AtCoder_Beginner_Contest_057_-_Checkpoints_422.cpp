#include<bits/stdc++.h>
using namespace std;
struct node{
	int x,y;
}a[10010],b[10010];
int jl(int x1,int x2,int y1,int y2){
	return abs(x1-x2)+abs(y1-y2);
}
int main(){
	int n,m,i,j,mn,id;
	cin>>n>>m;
	for(i=1;i<=n;i++){
		cin>>a[i].x>>a[i].y;
	}
	for(i=1;i<=m;i++){
		cin>>b[i].x>>b[i].y;
	}
	for(i=1;i<=n;i++){
		mn=2100000000;
		for(j=1;j<=m;j++){
			if(jl(a[i].x,b[j].x,a[i].y,b[j].y)<mn){
				mn=jl(a[i].x,b[j].x,a[i].y,b[j].y);
				id=j;
			}
		}
		cout<<id<<endl;
	}
	return 0;
}
