
#include<iostream>
#include<cmath>
using namespace std;
int main(){
	int i,j,n,m,no,len,Min;
	cin>>n>>m;
	int a[n+5],b[n+5];
	for(i=1;i<=n;i++)cin>>a[i]>>b[i];
	int c[m+5],d[m+5];
	for(i=1;i<=m;i++)cin>>c[i]>>d[i];
	for(i=1;i<=n;i++){
		no=1;
		Min=abs(a[i]-c[1])+abs(b[i]-d[1]);
		for(j=2;j<=m;j++){
			len=abs(a[i]-c[j])+abs(b[i]-d[j]);
			if(len<Min){
				Min=len;
				no=j;
			}
		}
		cout<<no<<endl;
	}
	return 0;
}