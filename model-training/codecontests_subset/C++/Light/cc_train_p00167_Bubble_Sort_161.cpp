#include <iostream>
using namespace std;
int bubble_sort(int date[], int n){
	int count = 0;
	for(int i=0;i<n-1;i++){
		for(int j=n-1;j>i;j--){
			if(date[j]<date[j-1]){
				int tmp = date[j];
				date[j] = date[j-1];
				date[j-1] = tmp;
				count++;
			}
		}
	}
	return(count);
}
			

int main(void)
{
	int n;
	int date[100];
	while(cin>>n){
		if(!n) break;
		for(int i = 0; i < n; i++){
			cin >> date[i];
		}
		cout << bubble_sort(date,n) << endl;
	}
	return 0;
}