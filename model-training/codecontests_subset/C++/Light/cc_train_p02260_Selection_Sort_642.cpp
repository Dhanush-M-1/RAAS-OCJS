#include<iostream>
using namespace std;

int main()
{
	int N, A[100];
	cin >> N;
	for (int i = 0; i < N; i++) cin >> A[i];

	int count = 0;
	for (int i = 0; i < N; i++) {
		int minj = i;
		for (int j = i; j < N; j++) {
			if (A[j] < A[minj]) {
				minj = j;
			}
		}
		if (i != minj) {
			swap(A[i], A[minj]);
			count++;
		}
	}
	cout << A[0];
	for (int i = 1; i < N; i++) {
		cout << " " << A[i];
	}
	cout << endl << count << endl;
}