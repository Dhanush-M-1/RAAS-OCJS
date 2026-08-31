#include<iostream>
using namespace std;

const int MAX = 100;
int A[MAX];
int N;
int main()
{
	cin >> N;
	for (int i = 0; i < N; ++i) cin >> A[i];
	int minj;
	int cnt = 0;
	for (int i = 0; i < N; ++i)
	{
		minj = i;
		for (int j = i + 1; j < N; ++j)
		{
			if (A[j] < A[minj]) minj = j;
		}
		if (i != minj)
		{
			swap(A[i], A[minj]);
			cnt++;
		}
	}
	for (int i = 0; i < N; ++i)
	{
		if (i) cout << ' ';
		cout << A[i];
	}
	cout << endl;
	cout << cnt << endl;
	return 0;
}
