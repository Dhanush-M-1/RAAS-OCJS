#include <iostream>

using namespace std;

int main(){
	int q,n,cnt,d,max;
	cin >> q;
	for(int i = 0; i < q; i++){
		cin >> n;
		cnt = 0;
		while(n >= 10){
			max = (n % 10) * (n / 10);
			for(d = 100; d < n; d *= 10){
				int x,y;
				x = n % d;
				y = n / d;
				if(max < x * y) max = x * y;
			}
			n = max;
			cnt++;
		}
		cout << cnt << endl;
	}
	return 0;
}