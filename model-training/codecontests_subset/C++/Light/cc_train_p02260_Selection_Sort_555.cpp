#include <iostream>
#include <algorithm>
using namespace std;

int main(void)
{
	int n, a[100], num = 0;
	cin >> n;
	for(int i = 0; i < n; i++) {
		cin >> a[i];
	}
	for(int i = 0; i < n; i++) {
		int minj = i;
		for(int j = i; j < n; j++) {
			if(a[j] < a[minj]){
				minj = j;
			}
		}
		if(i != minj){
			num++;
			swap(a[i], a[minj]);
		}
		cout << a[i] << (i == n - 1 ? "\n" : " ");
	}
	cout << num << endl;
	return 0;
}
