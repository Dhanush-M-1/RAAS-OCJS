#include <iostream>

using namespace std;

int main(){
	int a[100], n, minj, tmp, num;

	num = 0;
	cin >> n;
	for (int i = 0; i < n; i++){
		cin >> a[i];
	}

	for(int i = 0; i < n - 1; i++){
		minj = i;
		for (int j = i + 1; j < n; j++){
			if (a[j] < a[minj]){
				minj = j;
			}
		}if(minj != i){
			tmp = a[i];
			a[i] = a[minj];
			a[minj] = tmp;
			num++;
		}
	}
	cout << a[0];
	for(int i = 1; i < n; i++){
		cout << " " << a[i];
	}
	
	cout << "\n" << num << endl;
}