#include<iostream>
using namespace std;

int main() {
	int n;
	cin >> n;
	int A[111];
	for (int i = 0; i < n; i++) cin >> A[i];
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		int minj = i;
		for (int j = i; j < n; j++) {
			if (A[j] < A[minj]) {
				minj = j;
			}
		}
		if (i != minj) {
			swap(A[i], A[minj]);
			cnt++;
		}
	}
	for (int i = 0; i < n; i++) cout << A[i] << " \n"[i == n - 1];
	cout << cnt << endl;
	return 0;
}
