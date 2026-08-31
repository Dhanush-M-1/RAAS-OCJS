#include<iostream>
#include<vector>
#include<string>

using namespace std;

int check(vector<int> tanka){
	int roule[] = {5,7,5,7,7};
	int index = 0, i = 0, t = 0;
	int sum = 0;
	while(i < 5){
		do{
			sum += tanka[index+t];
			t++;
		}while(sum < roule[i]);
		if(sum > roule[i]){
			index++;
			i = 0;
			t = 0;
		}else{
			i++;
		}
		sum = 0;
	}
	return index+1;
}

int main(){
	vector<int> tanka;
	vector<int> res;
	int n;
	do{
		cin >> n;
		for(int i=0;i<n;i++){
			string tmp;
			cin >> tmp;
			tanka.push_back(tmp.size());
		}
		if(n > 0)
			res.push_back(check(tanka));
		tanka.clear();
		tanka.shrink_to_fit();
	}while(n > 0);

	for(auto num : res){
		cout << num << endl;
	}
	
	return 0;
}