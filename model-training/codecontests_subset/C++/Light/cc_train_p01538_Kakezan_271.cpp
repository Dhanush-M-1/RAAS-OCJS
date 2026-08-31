#include <iostream>
#include <cmath>

using namespace std;

int main(){
	int q;
	cin >> q;
	for(int i = 0; i < q; i++){
		int n;
		int cnt = 0;
		cin >> n;
		while(n >= 10){
			int m = 0;
			int a = n;
			for(int j = 1; j < log10(n); j++){
				int k = pow(10,j);
				m = max(m,(n/k)*(n%k));
			}
			n = m;
			if(a == n){
				cnt = -1;
				break;
			}
			cnt++;
		}
		cout << cnt << endl; 
	}
	return 0;
}