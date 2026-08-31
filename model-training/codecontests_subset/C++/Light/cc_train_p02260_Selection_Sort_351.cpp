#include<iostream>
using namespace std;
int main()
{
	int N, A[100], i, j, min, temp, num = 0;
	cin >> N;
	for (i = 0; i < N; i++)
		cin >> A[i];
	for (i = 0; i < N; i++)
	{
		min = i;
		for (j = i; j < N; j++)
			if (A[j] < A[min])
				min = j;
		if (min != i)
		{
			temp = A[i];
			A[i] = A[min];
			A[min] = temp;		
			num++;
		}
	}
	for (i = 0; i < N - 1; i++)
		cout << A[i] << ' ';
	cout << A[N - 1] << endl;
	cout << num << endl;
	return 0;
}
