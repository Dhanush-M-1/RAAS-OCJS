#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	int n;
	int array[100];

	while (cin >> n, n){
		int cnt = 0;
		for (int i = 0; i < n; i++){
			cin >> array[i];
		}
		for (int i = 0; i < n - 1; i++){
			for (int j = n - 1; j > i; j--){
				if (array[j] < array[j - 1]){
					swap(array[j], array[j - 1]);
					cnt++;
				}
			}
		}
		cout << cnt << endl;
	}

	return (0);
}