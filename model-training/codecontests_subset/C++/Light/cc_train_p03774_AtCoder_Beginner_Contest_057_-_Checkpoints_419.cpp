#include<iostream>
using namespace std;

int main(){
	int n,m;
	cin >> n >> m;
	int sdt[n][2],pt[m][2];
	for(int i=0;i<n;++i)
	cin >> sdt[i][0] >> sdt[i][1];
	for(int i=0;i<m;++i)
	cin >> pt[i][0] >> pt[i][1];
	
	for(int i=0;i<n;++i){
		int min=abs(sdt[i][0]-pt[0][0])+abs(sdt[i][1]-pt[0][1]),idx=1,d;
		for(int j=1;j<m;++j){
			d=abs(sdt[i][0]-pt[j][0])+abs(sdt[i][1]-pt[j][1]);
			if(d<min){
				min=d;
				idx=j+1;
			}
		}
		cout << idx << endl;
	}
	return 0;
}