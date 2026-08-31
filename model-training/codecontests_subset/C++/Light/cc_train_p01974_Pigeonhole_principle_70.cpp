#include <iostream>
#include <algorithm>
using namespace std;

int n;
int a[1000];

int main() {
	int i, j;
	
	cin >> n;
	for (i = 0; i < n; i++) cin >> a[i];
	sort(a, a + n);
	
	for (i = 0; i < n; i++) {
		for (j = i + 1; j < n; j++) {
			if ((a[j] - a[i]) % (n - 1) == 0) {
				cout << a[i] << " " << a[j] << endl;
				return 0;
			}
		}
	}
	return 0;
}
