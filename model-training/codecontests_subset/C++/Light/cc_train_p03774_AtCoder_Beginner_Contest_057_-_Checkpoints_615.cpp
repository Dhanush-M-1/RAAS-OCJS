#include<iostream>
#include<cmath>
#include<algorithm>
using namespace std;

int main(){
	int n,m;
	long long a[60],b[60],c[60],d[60];
	cin >> n >> m;
	for(int i=0; i<n; i++){
		cin >> a[i] >> b[i];
	}
	for(int i=0; i<m; i++){
		cin >> c[i] >> d[i];
	}
	for(int i=0; i<n; i++){
		int minnum=1e9,mini=51;
		for(int k=0; k<m; k++){
			int tmp =abs(a[i]-c[k])+abs(b[i]-d[k]);
			if(tmp<minnum){
				minnum=tmp;
				mini=k;
			}
		}
		cout << mini+1 << endl;
	}

}





