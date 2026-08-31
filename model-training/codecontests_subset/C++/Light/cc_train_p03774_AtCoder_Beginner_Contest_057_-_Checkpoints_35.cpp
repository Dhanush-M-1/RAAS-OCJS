#include <bits/stdc++.h>
using namespace std;

int main() {
	long n,m,i,j,cur,res;
	cin >> n >> m;
	vector<long> a(n),b(n),c(m),d(m);
	for(i=0; i<n; i++){
		cin >> a[i] >> b[i];
	}
	for(i=0; i<m; i++){
		cin >> c[i] >> d[i];
	}
	for(i=0; i<n; i++){
		cur=0; res=1000000000;
		for(j=0; j<m; j++){
			if(res>abs(a[i]-c[j])+abs(b[i]-d[j])){
				cur=j;
				res=abs(a[i]-c[j])+abs(b[i]-d[j]);
			}
		}
		cout << cur+1 << endl;
	}
}