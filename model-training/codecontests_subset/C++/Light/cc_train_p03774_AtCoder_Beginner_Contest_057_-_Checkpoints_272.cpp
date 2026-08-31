#include<bits/stdc++.h>
using namespace std;
struct node{
	int x,y;
};
node a[101],b[101];

int dist(node da,node db){
	return abs(da.x-db.x)+abs(da.y-db.y);
}
int main(){
	int i,j,n,m,id,dism,disc;
	cin>>n>>m; 
	for(i=1;i<=n;i++){
		cin>>a[i].x>>a[i].y;
	} 
	for(j=1;j<=m;j++){
		cin>>b[j].x>>b[j].y;
	}
	for(i=1;i<=n;i++){
		dism=dist(a[i],b[1]);
		id=1;
		for(j=2;j<=m;j++){
			disc=dist(a[i],b[j]);
			if(disc<dism){
				dism=disc;
				id=j;
			}
		}
		cout<<id<<endl; 
	}
	return 0;
} 