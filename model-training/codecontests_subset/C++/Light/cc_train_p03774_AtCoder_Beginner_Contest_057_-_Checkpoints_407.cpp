#include<bits/stdc++.h>
using namespace std;
struct nod{
	int x,y;
}a[100];
nod b[100];
int n,m,num[100];
int main(){
	cin>>n>>m;
	for(int i=1;i<=n;i++)cin>>a[i].x>>a[i].y;
	for(int i=1;i<=m;i++)cin>>b[i].x>>b[i].y;
	for(int i=1;i<=n;i++){
		int maxx=1<<30;
		for(int j=1;j<=m;j++){
			if((abs(a[i].x-b[j].x)+abs(a[i].y-b[j].y))<maxx){
				maxx=abs(a[i].x-b[j].x)+abs(a[i].y-b[j].y);
				num[i]=j;	
			}
		}
		cout<<num[i]<<endl;
	}
cout<<endl;
	return 0;
}