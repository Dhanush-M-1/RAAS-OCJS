#include<iostream>
using namespace std;
int n, cnt;
int a[100000];

void _swap(int p, int q, int v, int w) {
	int c, d;
	c = p;
	d = q;
	p = d;
	q = c;
	a[v] = p;
	a[w] = q;
}

int main() {
	while (true){
		cnt = 0;
		cin >> n;
		if (n == 0) { break; }
		for (int i = 0; i < n; i++) {
			cin >> a[i];
		}
		for (int i = n - 1; i >= 0; i--){
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					cnt++;
					_swap(a[j], a[j + 1], j, j + 1);
				}
			}
		}
		cout << cnt << endl;
	}
}