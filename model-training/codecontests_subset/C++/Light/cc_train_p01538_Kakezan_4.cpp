#include<iostream>
using namespace std;
#define rep(i, j) for(int i = 0; i < j; i++)

int retMax(int n){
	int ret = -1;
	for(int i = 10; n % i != n; i *= 10){
		int a = n / i, b = n % i;
		ret = max(ret, a * b);
	}
	return ret;
}

int main(){
	int q;
	cin >>q;
	for(int z = 0; z < q; z++){
		int n, ans = 0; cin >>n;
		while(n >= 10){
			int befn = n;
			n = retMax(n);
			ans++;
			if(befn < n){
				ans = -1;
				break;
			}
		}
		cout <<ans <<endl;
	}
	return 0;
}