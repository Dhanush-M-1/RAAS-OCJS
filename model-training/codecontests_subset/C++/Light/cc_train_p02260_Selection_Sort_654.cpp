#include <iostream>
using namespace std;

int main(){
	int i=0;
	int N;
	cin >> N;
	int A[N];
	for(int i=0;i<N;i++){
		cin >> A[i];
	}
	int count=0;
	for(int i=0;i<N;i++){
		int minj=i;
		for(int j=i;j<N;j++){
			if(A[minj] > A[j]){
				minj=j;
			}
		}
		if(i!=minj){
			int temp = A[i];
			A[i] = A[minj];
			A[minj]=temp;
			count++;
		}
	}
	for(int i=0;i<N;i++){
		cout << A[i];
		if(i != N-1)
			cout << " ";

	}
	cout << endl << count << endl;

	return 0;
}