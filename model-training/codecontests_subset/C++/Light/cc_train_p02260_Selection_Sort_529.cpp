#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int n;
	cin >> n;
	int a[n];
	int count = 0;
	for(int i=0;i<n;i++){
		cin >> a[i];
	}
	
	for(int i=0;i<n;i++){
		int minj = i;
		for(int j=i+1;j<n;j++){
			if(a[j]<a[minj]){
				minj = j;
			}
		}
		if(a[i]>a[minj]){
			swap(a[i],a[minj]);
			count++;
		}
	}
	
	for(int i=0;i<n;i++){
		cout << a[i] ;
		if(i<n-1) cout << " ";
	}
	cout << endl;
	cout << count << endl;
	
	return 0;
}
