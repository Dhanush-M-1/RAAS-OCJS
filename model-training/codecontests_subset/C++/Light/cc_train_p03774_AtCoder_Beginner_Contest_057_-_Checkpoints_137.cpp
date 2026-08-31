#include<iostream>
#include<complex>
using namespace std;
int a[99],b[99],c[99],d[99],n,m;
int main(){
	cin>>n>>m;
	for(int i=0;i<n;i++)cin>>a[i]>>b[i];
	for(int j=0;j<m;j++)cin>>c[j]>>d[j];
	for(int i=0;i<n;i++){
		int ans=0;
		for(int j=1;j<m;j++){
			if(abs(a[i]-c[j])+abs(b[i]-d[j])<abs(a[i]-c[ans])+abs(b[i]-d[ans])){
				ans=j;
			}
		}
		cout<<ans+1<<endl;
	}
	return 0;
}