#include <iostream>
#include <cstdlib> 
using namespace std;
int main(){
	int n, count = 0;
	cin >> n;
	int A[n];
	for(int i = 0; i < n; i++) cin >> A[i];
	for(int i = 0; i < n; i++){
		int min = i;
		for(int j = i; j < n; j++) if(A[j] < A[min]) min = j;
		int tmp = A[min];
		A[min] = A[i];
		A[i] = tmp;
		if(min != i) count ++;
	}
	for(int i = 0; i < n; i++){
		cout << A[i];
		if(i != n - 1) cout << ' ';
	}
	cout << '\n' << count << endl;
}

