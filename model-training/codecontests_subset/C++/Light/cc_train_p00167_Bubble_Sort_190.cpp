#include <iostream>
#include <algorithm>
using namespace std;

int num[1000001];

int BubbleSort(int n)
{	
	int k = 0, ct = 0;
	bool flag = true;
	
	do {
		flag = true;
		
		for (int i = 0; i < n - 1 - k; i++){
			if (num[i] > num[i + 1]){
				flag = false;
				swap(num[i], num[i + 1]);
				ct++;
			}
		}
		k++;
	}while (!flag);
	return (ct);
}

int main()
{
	int n;
	
	while (cin >> n, n){
		for (int i = 0; i < n; i++){
			cin >> num[i];
		}
		int ct = BubbleSort(n);
		cout << ct << endl;
	}
	return (0);
}