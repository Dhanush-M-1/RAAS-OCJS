#include<iostream>
#include<algorithm>
#include<vector>
#include <cassert>

using namespace std;

int N, k, sum, A[100];

int bubble_sort_count(int r){
	sum = 0;
	for (int i = 0; i < r - 1;i++){
		for (int j = 0; j < r - i - 1;j++){
			if (A[j] > A[j + 1]){
				k = A[j + 1];
				A[j + 1] = A[j];
				A[j] = k;
				sum += 1;
			}
		}
	}
	return sum;
}

int main()
{
	cin >> N;
	while (N != 0){
		for (int n = 0; n < N; n++){
			cin >> A[n];
		}
		cout << bubble_sort_count(N) << endl;
		cin >> N;
	}
}