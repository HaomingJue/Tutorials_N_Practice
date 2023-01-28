#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool is_even(int n) {
    return (n % 2) == 0;
}

int main() {
    vector<int> v{4, 3, 2, 1, 5};
    cout << "Elements of vector: ";

    for (auto i : v) {
        cout << i << ", ";
    }
    cout << endl;
    auto n_even = count_if(v.begin(), v.end(), is_even);
    cout << n_even << endl;

    auto num_even = count_if(v.begin(), v.end(), [](int n) {
        return (n % 2) == 0;
    });

    cout << "number of even with lambda functions " << num_even << endl;

    return 0;
}