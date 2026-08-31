#include <iostream>
using namespace std;

int main() {
	int i,N,m,d,s;
	d=10;
	cin >> N;
	for (int k=0; k<N; k++) {
		cin >> m;
		while (m>9) {
			i += 1;
			while (m % d != m) {
				int lower = m%d;
				int upper = (m-lower)/d;
				int mlp = lower * upper;
				if(s < mlp) s = mlp;
				d *= 10;
			}
			m = s;
			d=10;
			s=0;
		}
		cout << i << endl;
		i=0;
	}
}