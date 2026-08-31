#include <iostream>
using namespace std;

int main()
{
	int Q;
	cin >> Q;
	for (int ite = 0; ite < Q; ite++) {
		long long int N,res = 0;
		cin >> N;
		while (N >= 10) {
			long long int max = 0;
			for (long long int i = 1; i <= N; i *= 10) {
				if (max < (N % i) * (N / i)) {
					max = (N % i) * (N / i);
				}
			}
			N = max;
			res++;
		}
		cout << res << endl;
	}
	return 0;
}