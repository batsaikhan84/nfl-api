class CreateMatrics < ActiveRecord::Migration[6.0]
  def change
    create_table :matrics do |t|
      t.string :like
      t.string :retweet
      t.string :impression
      t.string :new-follower
      t.string :tweet-id

      t.timestamps
    end
  end
end
