#include<iostream>
#include<math.h>
using namespace std;

int main()
{
	int n,m,a[50],b[50],c[50],d[50];
	cin>>n>>m;
	for(int i=0;i<n;i++) cin>>a[i]>>b[i];
	for(int i=0;i<m;i++) cin>>c[i]>>d[i];
	
	int minv,v[50];
	for(int i=0;i<n;i++){
		minv=abs(a[i]-c[0])+abs(b[i]-d[0]);
		v[i]=1;
		for(int j=1;j<m;j++){
			if(minv>abs(a[i]-c[j])+abs(b[i]-d[j])){
				minv=abs(a[i]-c[j])+abs(b[i]-d[j]);
				v[i]=j+1;
			}
		}
	}
	
	for(int i=0;i<n;i++) cout<<v[i]<<endl;
	
	return 0;
}
