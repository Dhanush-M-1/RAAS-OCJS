#include <iostream>
using namespace std;

int main(){
	int n, a[100], c = 0;
	cin >> n;
	for (int i = 0; i < n; i++)cin >> a[i];
	for (int i = 0; i < n; i++) {
		int minj = i;
		for (int j = i; j < n; j++) {
			if (a[minj] > a[j]) {
				minj = j;
			}
		}
		if (a[minj] != a[i])c++;
		int tmp = a[minj];
		a[minj] = a[i];
		a[i] = tmp;
	}
	for (int i = 0; i < n - 1; i++)cout << a[i] << " ";
	cout << a[n - 1] << endl << c << endl;

	return 0;
}