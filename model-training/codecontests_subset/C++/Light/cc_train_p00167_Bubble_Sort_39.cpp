#include<iostream>
#define MAX 10000
using namespace std;
int b_sort(int x[], int n){
	int count=0, temp;
		for(int i=0; i<n-1; i++){
			for(int j=n-1; j>i; j--){
				if(x[j-1] > x[j]){
					temp = x[j];
					x[j] = x[j-1];
					x[j-1] = temp;
					count++;
				}
			}
		}
	return count;
}

int main(){
	int x[MAX], n, p;
	while(1){
		cin >> n;
		if(n == 0) return 0;
		for(int i=0; i<n; i++) x[i]=0;
		for(int i=0; i<n; i++){
			cin >> p;
			x[i] = p;
		}
		cout << b_sort(x,n) << endl;
	}
}