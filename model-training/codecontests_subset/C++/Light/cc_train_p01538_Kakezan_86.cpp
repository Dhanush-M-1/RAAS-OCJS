#include <bits/stdc++.h>

using namespace std;

int power10(int x);
int GetDigit(int x);

int main(void)
{
	int Q;
	cin >> Q;
	for(int i=0;i<Q;i++){
		int N, cnt=0;
		cin >> N;
		while(N >= 10){
			int Digit;
			int maxi = 0;
			Digit = GetDigit(N);
			for(int j=1;j<Digit;j++){
				int n, m;
				n = N / power10(Digit-j);
				m = N - n*power10(Digit-j);
				maxi = max(maxi, n*m);
			}
			N = maxi;
			cnt++;
		}
		cout << cnt << endl;
	}
	return 0;
}

int power10(int x){
	if (x==0){
		return 1;
	}
	return power10(x-1)*10;
}

int GetDigit(int x){
	int ret=0;
	int n=x;
	do{
		ret++;
	}while((n/=10) != 0);
	return ret;
}
