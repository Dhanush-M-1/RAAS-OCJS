#include<iostream>
using namespace std;
int main() {
	int n; cin >> n;
	int a[100];
	for (int i = 0; i < n; i++)cin >> a[i];
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		int minj = i;
		for (int j = i; j < n; j++) {
			if (a[j] < a[minj]) {
				minj = j;
			}
		}
		swap(a[i], a[minj]); if(i!=minj)cnt++;
	}
	for (int i = 0; i < n; i++) {
		if (i > 0)cout << " ";
		cout << a[i];
	}
	cout << endl << cnt << endl;
	return 0;
}