#include <bits/stdc++.h>
using namespace std;

int main(void){
	int n;
	int a[200];
	int swap = 0;

	cin >> n;
	for(int i=0; i<n; i++){
		cin >> a[i];
	}
	

	for(int i=0; i<n; i++){
		int mini = i;
		for(int j=i; j<n; j++){
			if(a[j] < a[mini]){
				mini = j;
			}
		}
		int temp = a[mini];
		a[mini] = a[i];
		a[i] = temp;
		if(i!=mini)swap++;
	}
	
	for(int i=0; i<n; i++){
		if(i!=n-1)printf("%d ", a[i]);
		else printf("%d\n", a[i]);
	}
	printf("%d\n", swap);

	return 0;
}