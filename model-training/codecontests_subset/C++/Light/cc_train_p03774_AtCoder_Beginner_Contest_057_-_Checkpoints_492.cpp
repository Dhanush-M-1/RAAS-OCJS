#include<iostream>

using namespace std;
int main()
{
	long long n,m,a[55],b[55],c[55],d[55];
	cin >> n >> m;
	for(int i=0; i<n; i++){
		cin >> a[i] >> b[i];
	}
	for(int i=0; i<m; i++){
		cin >> c[i] >> d[i];
	}
	int ans;
	for(int i=0; i<n; i++){
		long long len = 2e9;
		for(int j=0; j<m; j++){
			if((abs(a[i] - c[j]) + abs(b[i] - d[j])) < len){
				len = abs(a[i] - c[j]) + abs(b[i] - d[j]);
				ans = j + 1;
			}
		}
		cout << ans << endl;
	}
	
	return 0;
}
