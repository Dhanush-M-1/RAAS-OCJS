#include <iostream>
#include <algorithm>

#define rep(i,n) for(int i=0;i<(int)(n);i++)

using namespace std;

int max_multi(int x)
{
	int maximum = 0;
	int y = 1;
	rep(i, 5){
		int a, b;
		y *= 10;
		a = x / y;
		b = x - a * y;
		maximum = max(maximum, a * b);
	}
	return maximum;
}

int main(void)
{
	int Q;
	cin >> Q;
	rep(i, Q){
		int N, cnt = 0;
		cin >> N;
		//Nが一桁になるまで繰り返す
		while(N >= 10){
			N = max_multi(N);
			cnt++;
		}
		cout << cnt << endl;
	}
	return 0;
}
