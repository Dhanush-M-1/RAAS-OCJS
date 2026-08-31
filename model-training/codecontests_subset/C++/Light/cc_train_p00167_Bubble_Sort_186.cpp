#include <iostream>
#include <stdio.h>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

int n, a[100], ct = 0;


int main()
{
	while (1){
		cin >> n;
		if (n == 0) break;
		for (int i = 0; i < n; i++) cin >> a[i];
		for (int j = 0; j < n; j++)
			for (int i = 0; i < n - 1; i++){
				if (a[i]>a[i + 1]){
					swap(a[i], a[i + 1]);
					ct++;
				}
			}
		cout << ct << endl;
		ct = 0;
	}
	return 0;
}