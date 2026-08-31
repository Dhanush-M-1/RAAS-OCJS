#include<iostream>
using namespace std;

int main(){
	int n,a[100],i,j,m,t,c;
	
	for(cin>>n,i=0;i<n;cin>>a[i],++i);
	
	for(c=0,i=0;i<n;++i){
		m=i;
		for(j=i;j<n;++j){
			if(a[j]<a[m]){
				m=j;
			}
		}
		t=a[i];
		a[i]=a[m];
		a[m]=t;
		if(i-m)++c;
	}
	
	for(i=0;i<n;cout<<(i?" ":"")<<a[i],++i);
	cout<<endl<<c<<endl;
  return 0;
}