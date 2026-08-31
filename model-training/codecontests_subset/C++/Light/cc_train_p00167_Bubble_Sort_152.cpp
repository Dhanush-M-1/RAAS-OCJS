#include<iostream>
#include<algorithm>
using namespace std;

int main(){
	int n;
	while(1){
		cin >>n;
		if(n == 0) break;
		int dx[101] = {0};
		for(int i = 0; i < n; i++){
			cin >>dx[i];
		}
		int comp = n, cnt = 0;
		while(comp != 1){
			for(int i = 0; i < (comp - 1); i++){
				if(dx[i] > dx[i + 1]){
					swap(dx[i], dx[i + 1]);
					cnt++;
				}
			}
			comp--;
		}
		cout <<cnt <<endl;
	}
	return 0;
}