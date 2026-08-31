#include <iostream>
#include <cstdlib>
#include <cmath>

using namespace std;
int main(){
	int N,M,sum=0,s=0;
	long long int a[50],b[50],c[50],d[50],ans[50],t[50];
	
	cin>>N>>M;
	for(int i=0;i<N;i++){
		cin>>a[i]>>b[i];
		 t[i]=10000000000;
	}
	for(int j=0;j<M;j++){
		cin>>c[j]>>d[j];
	}

	for(int i=0;i<N;i++){
		for(int j=0;j<M;j++){
			s=abs(a[i]-c[j])+abs(b[i]-d[j]);
			if(s<t[i]){
				t[i]=s;
				
				ans[i]=j+1;
			}
		}
		cout<<ans[i]<<endl;
	}
	


	return 0;
}
