#include <iostream>
using namespace std;

int N;
int A[110];
int main(){
	cin >> N;
	for(int i=0;i<N;i++){
		cin >> A[i];
	}
	int count = 0;
	for(int i=0;i<N;i++){
		int minj = i;
		for(int j=i;j<N;j++){
			if(A[j] < A[minj]){
				minj = j;
			}
		}
		int tmp = A[i];
		A[i] = A[minj];
		A[minj] = tmp;
		if(minj!=i) count++;
	}
	for(int i=0;i<N;i++){
		if(i!=N-1) cout << A[i] <<" ";
		else cout << A[i] << endl;
	}
	cout << count << endl;
}

