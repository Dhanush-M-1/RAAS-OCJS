#include<iostream>
using namespace std;
int main(){
	int n,m;
	cin >> n >> m;
	int a[50],b[50],c[50],d[50];
	for(int i=0;i<n;i++){
		cin >> a[i] >> b[i];
	}
	for(int i=0;i<m;i++){
		cin >> c[i] >> d[i];
	}
	
	for(int i=0;i<n;i++){
		int ans=1e9;
		int ansp=0;
		for(int j=0;j<m;j++){
			int x=abs(a[i]-c[j]);
			int y=abs(b[i]-d[j]);
			if(ans>x+y){
				ans=x+y;
				ansp=j+1;
			}
		}
		cout << ansp << endl;
	}
	return 0;
}
