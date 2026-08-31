#include <iostream>
using namespace std;

int Pow(int t){
	int ret = 1;
	for(int i = 0; i < t; i++) ret *= 10;
	return ret;
}

int main(){
	int n;
	cin >> n;
	for(int i = 0; i < n; i++){
		int r;
		cin >> r;
		int cnt = 0;
		while(true){
			if(r < 10) break;
			int x = 10;
			int rank;
			for(int i = 2;;i++){
				x *= 10;
				if(x > r){
					rank = i;
					break;
				}
			}
			int nr = 0;
			for(int i = 1; i <= rank-1; i++){
				int y = (r%Pow(i))*(r/Pow(i));
				if(y > nr) nr = y;
			}
			r = nr;
			cnt++;
		}
		cout << cnt << endl;
	}
}