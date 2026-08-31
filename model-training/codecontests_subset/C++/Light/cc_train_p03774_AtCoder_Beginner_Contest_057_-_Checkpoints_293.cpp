#include<bits/stdc++.h>
using namespace std;
 
int main(){
	int n,m;
	long long a[50],b[50],c[50],d[50];
	cin>>n>>m;
	for (int i = 0; i < n; i++){
		cin>>a[i]>>b[i];
	}
	for (int i = 0; i < m; i++){
		cin>>c[i]>>d[i];
	}

	long long md,p;
	for (int i = 0; i < n; i++){
		long long mp=1e16;
		for (int j = 0; j < m; j++){
			md=abs(a[i]-c[j])+abs(b[i]-d[j]);
			if(mp>md){
				mp=md;
				p=j+1;
			}
		}
		cout<<p<<endl;
	}

}

